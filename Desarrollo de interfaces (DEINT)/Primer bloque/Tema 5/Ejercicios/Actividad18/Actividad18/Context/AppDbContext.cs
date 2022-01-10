using Actividad18.Models;
using Microsoft.EntityFrameworkCore;

namespace Actividad18.Context
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options) : base(options)
        {
            
        }

        public DbSet<Estudiante> estudiantes { get; set; }
    }
}