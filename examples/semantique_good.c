/**
 * Exemple permettant d'afficher des tds
 **/

int recherche(int t){
    int p=0;
    
    if (t==2){
        p=8;
        print(p);
    }
    return p;
}

struct person_t
{
    int nom;
    int tel;
};

struct person_t* my_function (int x, int y) {
    struct person_t *p1;
    struct person_t *p2, *p3;
    int test=0;


    p2->nom = 1;
    p2->tel = 123456;


    return p1;
}

int controle(int test){
    int result = 0;
    struct person_t *p;
    int condition = 8;
    
    if (condition == 8){
        result = test;
    } else {
        int a = 5;
    }
    return result;
}



int main(){
    int a,b;
    a = 8/1;

    recherche(2);

    while(b != 2){
        int result;
        a = b+2;
        b = a-1;
        result = a+b;
    }
    return a;
}
