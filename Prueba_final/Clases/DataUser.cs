using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Prueba_final.Clases
{
    public class DataUser
    {
        public string Id { get; set; }
        public string Name { get; set; }
        public int Age { get; set; }
        public string World { get; set; }
        public string[] Guilds { get; set; }
        public string[] Guild_leader { get; set; }
        public string Created { get; set; }
        public string[] Access { get; set; }
        public bool Commander { get; set; }
        public int Fractal_level { get; set; }
        public int Daily_ap { get; set; }
        public int Monthly_ap { get; set; }
        public int Wvw_rank { get; set; }
    }
}