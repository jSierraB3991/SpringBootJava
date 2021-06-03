namespace proveedores_XamAndroid.Adapter
{
    using Android.App;
    using Android.Views;
    using Android.Widget;
    using proveedores_XamAndroid.Models;
    using System.Collections.Generic;


    public class ProvidersListAdapter : BaseAdapter<Provider>
    {
        private readonly List<Provider> _providers;
        private readonly Activity _activity;

        public ProvidersListAdapter(Activity context, List<Provider> items): base()
        {
            this._activity = context;
            this._providers = items;
        }

        public override Provider this[int position] 
            => this._providers[position];

        public override int Count
            => this._providers.Count;

        public override long GetItemId(int position) => position;

        public override View GetView(int position, View convertView, ViewGroup parent)
        {
            var item = this._providers[position];
            convertView = convertView ?? this._activity.LayoutInflater.Inflate(Resource.Layout.ProvidersRow, null);
            convertView.FindViewById<TextView>(Resource.Id.txtnameProvider).Text = item.Nombre;
            convertView.FindViewById<TextView>(Resource.Id.txtTelephone).Text = item.Telefono;
            return convertView;
        }
    }
}