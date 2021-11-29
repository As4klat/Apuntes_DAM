using System.ComponentModel.DataAnnotations;

namespace Actividad18.Models
{
    public class Estudiante
    {
        [Key]
        public int Id { get; set; }
        public string Nombre { get; set; }
        public string PrimerApellido { get; set; }
        public string SegundoApellido { get; set; }
        public string Email { get; set; }
        public string Foto { get; set; }
    }
}