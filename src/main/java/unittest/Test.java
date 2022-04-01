package unittest;

public class Test {

    public static void main(String[] args) {

testCalcAdd();


    }

public static void testCalcAdd(){

        Calculator calculator = new Calculator();
        int result =  calculator.sum(2,2);

        if(result !=4){
            throw new IllegalStateException("Wrong result, 2+2 is not 4");
        }else{
            System.out.println("OK");
        }
}

}
