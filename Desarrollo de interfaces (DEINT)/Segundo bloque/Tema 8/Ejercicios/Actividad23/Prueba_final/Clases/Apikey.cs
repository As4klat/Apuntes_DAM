using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Prueba_final.Clases
{
    public class Apikey
    {
        private string key;

        public Apikey(string key)
        {
            Key = key;
        }

        public string Key { get => key; set => key = value; }
    }
}