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
    public class Human
    {
        public string _name { get; }
        public DateTime _birthDate { get; }
        public DateTime? _deathDate { get; }
        public Gender _gender { get; }
        public Human? _mother { get; }
        public Human? _father { get; }
        public List<Human> _children { get; } = new List<Human>();
        public Human(string name, DateTime birthDate, Gender gender) : this(name, birthDate, gender, null, null)
        {
        }
        public Human(string name, DateTime birthDate, Gender gender, Human? mother, Human? father)
        {
            _name = name;
            _birthDate = birthDate;
            _gender = gender;
            _mother = mother;
            _father = father;
        }
        public void AddChild(Human child)
        {
            _children.Add(child);
        }
        public void AddChildren(List<Human> children)
        {
            _children.AddRange(children);
        }
        public override string ToString()
        {
            return $"{_name} {_gender} born {_birthDate} mother: {_mother?._name}" +
                $" father: {_father?._name}";
        }
        public string FamilyTree(int tabsCount = 1)
        {
            StringBuilder sb = new StringBuilder();
            sb.AppendLine(ToString());
            string tabs = new string('\t', tabsCount);
            tabsCount++;
            foreach(var child in _children)
            {
                sb.Append(tabs + child.FamilyTree(tabsCount));
            }
            return sb.ToString();
        }
    }
}
