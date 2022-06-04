package practice.designpatters;

 class Singleton {

        static Singleton singletonInstace = new Singleton(); // static instance
        private Singleton(){ // private constructor
        }
        public static Singleton getInstance(){ // static method to access obj
            return singletonInstace;
        }
        public void simpleMethod(){
            System.out.println("hashcode of getInstance" + singletonInstace);
        }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.simpleMethod(); // hashocde same for both : Singleton@7229724f
        Singleton singleton1 = Singleton.getInstance();
        singleton1.simpleMethod(); // hashocde same for both : Singleton@7229724f

    }
    }

