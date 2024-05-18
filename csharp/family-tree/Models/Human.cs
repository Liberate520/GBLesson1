using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace family_tree.Models
{
    public enum Gender
    {
        Male, Female
    }
    public abstract class Human
    {
        private string _name;
        private DateOnly _birthDate, _deathDate;
        private Gender _gender;
        private Human _mother, _father;
        private List<Human>? _children;
    }
}
