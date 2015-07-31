package crud.dao;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import crud.android_crud.R.id;
import crud.android_crud.R.layout;
import crud.model.Usuario;

public class UsuarioAdapter extends BaseAdapter {
	private Context context;

	private List<Usuario> usuarios;
	private LayoutInflater inflater;

	public UsuarioAdapter(Context context, List<Usuario> usuarios) {
		super();
		this.context = context;
		this.usuarios = usuarios;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public void notifyDataSetChanged() {
		try {
			super.notifyDataSetChanged();
		} catch (Exception e) {
			trace("Erro: " + e.getMessage());
		}
	}

	private void trace(String msg) {
		toast(msg);
	}

	public void toast(String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

	public int getCount() {
		return usuarios.size();
	}

	// Remover item da lista
	public void remove(final Usuario user) {
		this.usuarios.remove(user);
	}

	// Adicionar item na lista
	public void add(final Usuario user) {
		this.usuarios.add(user);
	}

	public Object getItem(int position) {
		return usuarios.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup viewGroup2) {
		try {
			Usuario usuario = usuarios.get(position);

			// O ViewHolder irá guardar a instâncias dos objetos do estado_row
			ViewHolder holder;

			// Quando o objeto convertView não for nulo nós não precisaremos
			// inflar
			// os objetos do XML, ele será nulo quando for a primeira vez que
			// for carregado
			if (convertView == null) {
				convertView = inflater.inflate(layout.contato_row, null);

				// Cria o Viewholder e guarda a instância dos objetos
				holder = new ViewHolder();
				holder.tvNome = (TextView) convertView.findViewById(id.txtNome);
				holder.tvCpf = (TextView) convertView.findViewById(id.txtCpf);
				holder.tvTelefone = (TextView) convertView.findViewById(id.txtTelefone);
				holder.tvEmail = (TextView) convertView.findViewById(id.txtEmail);

				convertView.setTag(holder);
			} else {
				// pega o ViewHolder para ter um acesso rápido aos objetos do
				// XML
				// ele sempre passará por aqui quando,por exemplo, for efetuado
				// uma rolagem na tela
				holder = (ViewHolder) convertView.getTag();
			}

			holder.tvNome.setText(usuario.getNome());
			holder.tvCpf.setText(usuario.getCpf());
			holder.tvTelefone.setText(usuario.getTelefone());
			holder.tvEmail.setText(usuario.getEmail());

			return convertView;

		} catch (Exception e) {
			trace("Erro : " + e.getMessage());
		}
		return convertView;
	}

	// Criada esta classe estática para guardar a referência dos objetos abaixo
	static class ViewHolder {
		public TextView tvNome;
		public TextView tvCpf;
		public TextView tvTelefone;
		public TextView tvEmail;
	}
}
