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

int main(){
    int a;
    //division par zero
    a = 2/0;

    //manque un parametre dans la fonction
    recherche();

    return a;
}

int controle(int test){
    int condition = 8;
    if (condition == 8){
        //variable result utilisee non declaree
        result = test;
    }
}