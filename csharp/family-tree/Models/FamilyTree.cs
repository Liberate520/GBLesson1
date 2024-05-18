using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace family_tree.Models
{
    public class FamilyTree
    {
        private List<Human> _tree;
        public FamilyTree()
        {
            _tree = new List<Human>();
        }
        public List<Human> Tree 
        { 
            get { return _tree; }
        }
        public void Add(Human human) 
        { 
            _tree.Add(human);
        }
        public void Remove(Human human) 
        {
            _tree.Remove(human);
        }
        public override string ToString() 
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("Family tree:\n");
            if (Tree != null) { sb.AppendLine("Empty"); }
            foreach (Human human in _tree) 
            {
                sb.AppendLine(human.ToString());
            }
            return sb.ToString();
        }
        public void GenerateChildren(int count,Human mother, Human father)
        {
            for (int i = 0; i < count; i++)
            {
                Human child1 = new Human(_tree.Count.ToString(), DateTime.Now, Gender.Female, mother, father);
                _tree.Add(child1);
                Human child2 = new Human(_tree.Count.ToString(), DateTime.Now, Gender.Male, mother, father);
                _tree.Add(child2);
                GenerateChildren(count-2, child1, child2);
                mother.AddChild(child1);
                mother.AddChild(child2);
                father.AddChild(child1);
                father.AddChild(child2);
            }
        }
        public void Generate()
        {
            for(int i = 0; i < 2; i++)
            {
                Gender gender = i % 2 == 0 ? Gender.Male : Gender.Female;
                _tree.Add(new Human(i.ToString(), DateTime.Now, gender));
            }
            GenerateChildren(6,_tree.ElementAt(0), _tree.ElementAt(1));
            //return _tree;
        }
    }
}
