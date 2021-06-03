using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Support.V7.App;
using Android.Views;
using Android.Widget;
using proveedores_XamAndroid.Adapter;
using proveedores_XamAndroid.Service;

namespace proveedores_XamAndroid.Activities
{
    [Activity(Label = "@string/providerlist", Theme = "@style/AppTheme", MainLauncher = true)]
    public class ProvidersActivity : AppCompatActivity
    {
        private ApiService _apiseservice;
        private ListView _providersList;

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            SetContentView(Resource.Layout.ProviderLayout);
            this._providersList = FindViewById<ListView>(Resource.Id.lvprovidersList);
            this._apiseservice = new ApiService();
            this.LoadProviders();
        }

        private void LoadProviders()
        {
            var response = this._apiseservice.ChechConnection();
            if (!response.IsSuccess) 
            {
                Toast.MakeText(this, response.Message, ToastLength.Short).Show();
                return;
            }

            var response2 = this._apiseservice.GetList(string.Empty, string.Empty, string.Empty);
            if (!response2.IsSuccess)
            {
                Toast.MakeText(this, response.Message, ToastLength.Short).Show();
                return;
            }
            this._providersList.Adapter = new ProvidersListAdapter(this, response2.Result);
            this._providersList.FastScrollEnabled = true;
        }
    }
}