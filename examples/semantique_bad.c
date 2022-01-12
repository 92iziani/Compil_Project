/**
 * Exemple permettant de lister tous les contrôles semantiques 
 **/

int recherche(int t){  //manque le return
    int p=0;
    if (t==2){
        p=8;
    }
}

struct person_t
{
    int nom;
    int tel;
    int nom;   //variable déjà définie

};


int controle(int test){
    struct person_t *p;

    int condition = 8;
    struct person_t *p1;
    struct person_t *p1, *p2, *p3; //la variable struct p1 est deja definie


    struct person_t *p;   //variable p deja definie

    p->nom=2;
    if (condition == 8){
        result = test;   //A REFAIRE variable result utilisee non declaree

    }
   
    return p; //mauvais type de retour
}

struct person_t* my_function (int x, int y) {
    struct person_t *p1;
    int test=0;
    struct person *p; //Le type de struct person n'existe pas

    print(p); //Print ne prend que des int

    p1->nom = 1;
    p1->telephone = 123456; //Le champ téléphone n'existe pas dans la struct p1 de type person_t

    test = sizeof(struct aa); // Le type n'exsite pas
    return test; //mauvais type de retour
}

struct person_t* test_retour(){
    return 5;  //Le type de retour n'est pas int donc un entier ne peut pas être retourné
}



int main(){
    int a;
    a = 2/0;  //division par zero

    recherche(); //manque un parametre dans la fonction 

    rechercher();  //la fonction rechercher n'existe pas

    while(b != 2){   //la variable b n'est pas définie

        int resultat;
         
        a = b+2; //la variable b n'est pas definie
        
        b = a-1; //la variable b n'est pas definie
        resultat = 3;
    }
    
    return resultat; //n'a pas accès a resultat
}
