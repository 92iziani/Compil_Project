/**
 * Exemple permettant de lister tous les contrôles semantiques 
 **/

int recherche(int t){
    int p=0;
    
    if (t==2){
        p=8;
    }
    //manque le return
}



int controle(int test){
    int condition = 8;
    if (condition == 8){
        //variable result utilisee non declaree
        result = test;
    }
    return condition;
}

struct person_t
{
    int nom;
    int tel;
};

int main(){
    int a;
    //division par zero
    a = 2/0;

    //manque un parametre dans la fonction
    recherche();

    //la fonction rechercher n'existe pas
    rechercher(); 

    while(b != 2){
        int resultat;
        a = b+2;
        b = a-1;
        resultat = a+b;
    }
    //n'a pas accès a result
    return resultat;
}