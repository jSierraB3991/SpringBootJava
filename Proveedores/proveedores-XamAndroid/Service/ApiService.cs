namespace proveedores_XamAndroid.Service
{
    using Newtonsoft.Json;
    using proveedores_XamAndroid.Models;
    using System;
    using System.Collections.Generic;

    public class ApiService
    {
        public Response<string> ChechConnection() 
        {
            try
            {
                return new Response<string> { IsSuccess = true };
            }
            catch (Exception ex)
            {
                return new Response<string> { IsSuccess = false, Message = ex.Message };
            }
        }

        public Response<List<Provider>> GetList(string url, string api, string controller) 
        {
            try
            {
                string providers = "[ { id: 1, nombre: 'Juan David Sierra', fechaRegistro: '15/12/2019', telefono: '1234567'," +
                                   " direccion: 'Calle Luna, Calle Sol' }, { id: 3, nombre: 'Sanider Lopez Mendoza', " +
                                   "fechaRegistro: '15/12/2019', telefono: '5378941', direccion: 'Turbaco' }, { id: 4, " +
                                   "nombre: 'Jesus Cabrera', fechaRegistro: '15/12/2019', telefono: '8273695',  direccion: 'Medellin' } ]";
                return new Response<List<Provider>> { IsSuccess = true, Result = JsonConvert.DeserializeObject<List<Provider>>(providers) };

            }
            catch (Exception ex)
            {
                return new Response<List<Provider>> { IsSuccess =false, Message=ex.Message };
            }
        }
    }
}