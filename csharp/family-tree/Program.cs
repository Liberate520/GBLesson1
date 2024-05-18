using family_tree.Models;

FamilyTree ft = new FamilyTree();

ft.Generate();

Human? human = ft.Tree.FirstOrDefault();
Console.WriteLine(human?.FamilyTree());