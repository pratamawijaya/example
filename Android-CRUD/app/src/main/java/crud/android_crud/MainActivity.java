package crud.android_crud;

import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import crud.dao.UsuarioAdapter;
import crud.dao.UsuarioDAO;
import crud.model.Usuario;

public class MainActivity extends ListActivity {
	private static final int INCLUIR = 0;
	private static final int ALTERAR = 1;

	private UsuarioDAO usuarioDAO;
	List<Usuario> usuarios;
	UsuarioAdapter adapter;

	boolean blnShort = false;
	int posicao = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		usuarioDAO = new UsuarioDAO(this);
		usuarioDAO.open();
		usuarios = usuarioDAO.readAll();

		adapter = new UsuarioAdapter(this, usuarios);
		setListAdapter(adapter);

		registerForContextMenu(getListView());
	}

	// Este evento será chamado pelo atributo onClick
	// que está definido no botão criado no arquivo main.xml
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.add:
			InserirUsuario();
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Usuario user = null;

		try {
			super.onActivityResult(requestCode, resultCode, data);
			if (resultCode == Activity.RESULT_OK) {
				// obtem dados inseridos/alterados na Activity ContatoUI
				user = (Usuario) data.getExtras().getSerializable("usuario");

				// o valor do requestCode foi definido na função
				// startActivityForResult
				if (requestCode == INCLUIR) {
					// verifica se digitou algo no nome do contato
					if (!user.getNome().equals("")) {
						// necessário abrir novamente o BD pois ele foi fechado
						// no método onPause()
						usuarioDAO.open();

						// insere o contato no Banco de Dados SQLite
						usuarioDAO.create(user);

						// insere o contato na lista de contatos em memória
						usuarios.add(user);
					}
				} else if (requestCode == ALTERAR) {
					usuarioDAO.open();
					// atualiza o contato no Banco de Dados SQLite

					// atualiza o contato na lista de contatos em memória
					usuarios.set(posicao, user);
				}

				// método responsável pela atualiza da lista de dados na tela
				adapter.notifyDataSetChanged();
			}
		} catch (Exception e) {
			trace("Erro : " + e.getMessage());
		}
	}

	private void InserirUsuario() {
		try {
			// a variável "tipo" tem a função de definir o comportamento da
			// Activity
			// ContatoUI, agora a variável tipo está definida com o valor "0"
			// para
			// informar que será uma inclusão de Contato

			Intent it = new Intent(this, UsuarioUI.class);
			it.putExtra("tipo", INCLUIR);
			startActivityForResult(it, INCLUIR);// chama a tela e incusão
		} catch (Exception e) {
			trace("Erro : " + e.getMessage());
		}

	}

	public void toast(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	}

	private void trace(String msg) {
		toast(msg);
	}

	@Override
	protected void onResume() {
		// quando a Activity main receber o foco novamente abre-se novamente a
		// conexão
		usuarioDAO.open();
		super.onResume();
	}

	@Override
	protected void onPause() {
		// toda vez que o programa peder o foco fecha-se a conexão com o BD
		usuarioDAO.close();
		super.onPause();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		try {
			// Criação do popup menu com as opções que termos sobre
			// nossos Contatos

			AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
			if (!blnShort) {
				posicao = info.position;
			}
			blnShort = false;

			menu.setHeaderTitle("Selecione:");
			// a origem dos dados do menu está definido no arquivo arrays.xml
			String[] menuItems = getResources().getStringArray(R.array.menu);
			for (int i = 0; i < menuItems.length; i++) {
				menu.add(Menu.NONE, i, i, menuItems[i]);
			}
		} catch (Exception e) {
			trace("Erro : " + e.getMessage());
		}
	}

	// Este método é disparado quando o usuário clicar em um item do ContextMenu
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		Usuario user = null;
		try {
			int menuItemIndex = item.getItemId();

			// Carregar a instância POJO com a posição selecionada na tela
			user = (Usuario) getListAdapter().getItem(posicao);

			if (menuItemIndex == 0) {
				// Carregar a Activity ContatoUI com o registro selecionado na
				// tela

				Intent it = new Intent(this, UsuarioUI.class);
				it.putExtra("tipo", ALTERAR);
				it.putExtra("usuario", user);
				startActivityForResult(it, ALTERAR); // chama a tela de
														// alteração
			} else if (menuItemIndex == 1) {
				// Excluir do Banco de Dados e da tela o registro selecionado

				usuarioDAO.delete(user);
				usuarios.remove(user);
				adapter.notifyDataSetChanged(); // atualiza a tela
			}
		} catch (Exception e) {
			trace("Erro : " + e.getMessage());
		}
		return true;

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// por padrão o ContextMenu, só é executado através de LongClick, mas
		// nesse caso toda vez que executar um ShortClick, abriremos o menu
		// e também guardaremos qual a posição do itm selecionado

		posicao = position;
		blnShort = true;
		this.openContextMenu(l);
	}
}
