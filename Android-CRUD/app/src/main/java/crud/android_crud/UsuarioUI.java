package crud.android_crud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import crud.model.Usuario;

public class UsuarioUI extends Activity {
	private static final int INCLUIR = 0;
	// private static final int ALTERAR = 1;
	Usuario usuario;
	EditText txtNome;
	EditText txtCpf;
	EditText txtTelefone;
	EditText txtEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contato);

		try {

			final Bundle data = (Bundle) getIntent().getExtras();
			int lint = data.getInt("tipo");
			if (lint == INCLUIR) {
				// quando for incluir um contato criamos uma nova instância
				usuario = new Usuario();
			} else {
				// quando for alterar o contato carregamos a classe que veio por
				// Bundle
				usuario = (Usuario) data.getSerializable("usuario");
			}

			// Criação dos objetos da Activity
			txtNome =		(EditText) findViewById(R.id.edtNome);
			txtCpf =		(EditText) findViewById(R.id.edtCpf);
			txtTelefone =	(EditText) findViewById(R.id.edtTelefone);
			txtEmail =		(EditText) findViewById(R.id.edtEmail);

			// Carregando os objetos com os dados do Contato
			// caso seja uma inclusão ele virá carregado com os atributos text
			// definido no arquivo main.xml
			txtNome.setText(usuario.getNome());
			txtCpf.setText(usuario.getCpf());
			txtTelefone.setText(usuario.getTelefone());
			txtEmail.setText(usuario.getEmail());
		} catch (Exception e) {
			trace("Erro : " + e.getMessage());
		}
	}

	public void btnInserir_click(View view) {
		try {
			// Quando confirmar a inclusão ou alteração deve-se devolver
			// o registro com os dados preenchidos na tela e informar
			// o RESULT_OK e em seguida finalizar a Activity

			Intent data = new Intent();
			usuario.setNome(txtNome.getText().toString());
			usuario.setCpf(txtCpf.getText().toString());
			usuario.setTelefone(txtTelefone.getText().toString());
			usuario.setEmail(txtEmail.getText().toString());
			data.putExtra("usuario", usuario);
			System.out.println(usuario);
			setResult(Activity.RESULT_OK, data);
			finish();
		} catch (Exception e) {
			trace("Erro : " + e.getMessage());
		}
	}

	public void btnCancelar_click(View view) {
		try {
			// Quando for simplesmente cancelar a operação de inclusão
			// ou alteração deve-se apenas informar o RESULT_CANCELED
			// e em seguida finalizar a Activity

			setResult(Activity.RESULT_CANCELED);
			finish();
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

}
