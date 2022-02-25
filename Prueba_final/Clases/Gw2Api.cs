using Newtonsoft.Json;
using Prueba_final.Controladores;
using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Web;

namespace Prueba_final.Clases
{
    public class World
    {
        public string Id { get; set; }
        public string Name { get; set; }
        public string population { get; set; }
    }

    public class Gw2Api
    {
        private static string claveApi = LoginStatus.GetUsuario().Apikey;
        private static DataUser dataUser;

        public static void apiUsuario()
        {
            string url = $"https://api.guildwars2.com/v2/account?access_token={claveApi}";
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);
            HttpWebResponse response = (HttpWebResponse)request.GetResponse();
            Stream stream = response.GetResponseStream();
            using (StreamReader reader = new StreamReader(stream))
            {
                var json = reader.ReadToEnd();
                dataUser = JsonConvert.DeserializeObject<DataUser>(json);
            }
            
            
        }

        public static DataUser api()
        {
                apiUsuario();
                string url = $"https://api.guildwars2.com/v2/worlds/{dataUser.World}?lang=es";
                HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);
                HttpWebResponse response = (HttpWebResponse)request.GetResponse();
                Stream stream = response.GetResponseStream();
                using (StreamReader reader = new StreamReader(stream))
                {
                    var json = reader.ReadToEnd();
                    World world = JsonConvert.DeserializeObject<World>(json);
                    dataUser.World = world.Name;
                return dataUser;
                }
            
            
        }
    }
}