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

    //3. variable deja definie
    struct person_t *p;
    if (condition == 8){
        //4. variable result utilisee non declaree
        result = test;
    }
    //5. mauvais type de retour
    return p;
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
        b = a-1;
        resultat = a+b;
    }
    //11. n'a pas accès a resultat
    return resultat;
}