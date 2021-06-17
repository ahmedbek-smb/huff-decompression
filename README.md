# huff-decompression
Classes utilisés :

1)huff: cette classe s'occupe de la lecture du fichier d'entree ainsi que le creation de l'arbre de fuhhman 
corresendante à ce fichier texte elle est aussi responsable de la compression et la decompression du fichier.

2)Node: creation des noeuds qui ont chacun un charactere et une frequence.

3)Frequ : cette classe compare les frequence de deux noeuds et retourne leur difference.

Fonctionner le programme :

le code est fait de maniere simple pour rendre le projet facilement utilisable.

pour utiliser le programme on suit les etapes suivantes :
   
   -creer un fichier texte dans le meme dossier que le code source , ce fichier sera le parametre du code.
   
   -remplacer dans la classe huff le nom du fichier "exemple.txt" par celui qui est recemment cree.
   
   -on trouve alors deux fichiers creer dans le dossier du code source , le fichier "decomp.txt" qui est le fichier 
   decompresse et "comp.txt.huf" qui est le fichier compresse.
