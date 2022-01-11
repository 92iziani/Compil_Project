/**
 * Exemple permettant de lister tous les contrôles semantiques 
 **/

int recherche(int t){
    int p=0;
    
    if (t==2){
        p=8;
    }
    //1. manque le return
}

struct person_t
{
    int nom;
    int tel;
    //2. variable déjà définie
    int nom;
};


int controle(int test){
    struct person_t *p;

    int condition = 8;

    //3. variable p deja definie
    struct person_t *p;
    if (condition == 8){
        //4. variable result utilisee non declaree
        result = test;
    }
    //5. mauvais type de retour
    return p;
}

struct person_t* my_function (int x, int y) {
    int test=0;
    struct person_t *p2;
    //6. la variable struct p1 est deja definie
    struct person_t *p1, *p2, *p3;
    //7. Le type de struct person n'existe pas
    struct person *p;

    p1->nom = 1;
    //8. Le champ téléphone n'existe pas dans la struct p2 de type person_t
    p1->telephone = 123456;
    p1->aaaaa = 5;
    

    return sizeof(struct person_t);
}

struct person_t* test_retour(){
    //9. Le type de retour n'est pas int donc un entier ne peut pas être retourné
    return 5;
}



int main(){
    int a;
    //6. division par zero
    a = 2/0;

    //7. manque un parametre dans la fonction 
    recherche();

    //8. la fonction rechercher n'existe pas
    rechercher(); 

    //9. la variable b n'est pas définie
    while(b != 2){
        int resultat;
        //10. la variable b n'est pas definie
        a = b+2;
        //11. la variable b n'est pas definie
        b = a-1;
        resultat = 3;
    }
    //12. n'a pas accès a resultat
    return resultat;
}