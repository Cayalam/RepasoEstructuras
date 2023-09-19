public class ProblemaVueltos {
    public  static void main(String[] arg){
        int billetes100000;
        int billetes50000;
        int billetes20000;
        int billetes10000;
        int billetes5000;
        int billetes2000;
        int monedas1000;
        int monedas500;
        int monedas200;
        int monedas100;
        int monedas50;
        System.out.println("Ingrese la cantidad de billetes de 100000: ");
        billetes100000 = Integer.parseInt(System.console().readLine());
        System.out.println("Ingrese la cantidad de billetes de 50000: ");
        billetes50000 = Integer.parseInt(System.console().readLine());
        System.out.println("Ingrese la cantidad de billetes de 20000: ");
        billetes20000 = Integer.parseInt(System.console().readLine());
        System.out.println("Ingrese la cantidad de billetes de 10000: ");
        billetes10000 = Integer.parseInt(System.console().readLine());
        System.out.println("Ingrese la cantidad de billetes de 5000: ");
        billetes5000 = Integer.parseInt(System.console().readLine());
        System.out.println("Ingrese la cantidad de billetes de 2000: ");
        billetes2000 = Integer.parseInt(System.console().readLine());
        System.out.println("Ingrese la cantidad de monedas de 1000: ");
        monedas1000 = Integer.parseInt(System.console().readLine());
        System.out.println("Ingrese la cantidad de monedas de 500: ");
        monedas500 = Integer.parseInt(System.console().readLine());
        System.out.println("Ingrese la cantidad de monedas de 200: ");
        monedas200 = Integer.parseInt(System.console().readLine());
        System.out.println("Ingrese la cantidad de monedas de 100: ");
        monedas100 = Integer.parseInt(System.console().readLine());
        System.out.println("Ingrese la cantidad de monedas de 50: ");
        monedas50 = Integer.parseInt(System.console().readLine());
        System.out.println("Ingrese la cantidad de vueltos a devolver: ");
        int vueltos = Integer.parseInt(System.console().readLine());
        int V100000 = 0;
        int V50000 = 0;
        int V20000 = 0;
        int V10000 = 0;
        int V5000 = 0;
        int V2000 = 0;
        int V1000 = 0;
        int V500 = 0;
        int V200 = 0;
        int V100 = 0;
        int V50 = 0;
        if (vueltos/100000<=billetes100000) {
            V100000=vueltos/100000;
        }
        else{
            V100000=billetes100000;
        }
        if(vueltos-V100000*100000/50000<=billetes50000){
            V50000=(vueltos-V100000*100000)/50000;
        }
        else{
            V50000=billetes50000;
        }
        if(vueltos-V100000*100000-V50000*50000/20000<=billetes20000){
            V20000=(vueltos-V100000*100000-V50000*50000)/20000;
        }
        else{
            V20000=billetes20000;
        }
        if(vueltos-V100000*100000-V50000*50000-V20000*20000/10000<=10000){
            V10000=(vueltos-V100000*100000-V50000*50000-V20000*20000)/10000;
        }
        else{
            V10000=billetes10000;
        }
        if(vueltos-V100000*100000-V50000*50000-V20000*20000-V10000*10000/5000<=5000){
            V5000=(vueltos-V100000*100000-V50000*50000-V20000*20000-V10000*10000)/5000;
        }
        else{
            V5000=billetes5000;
        }
         if(vueltos-V100000*100000-V50000*50000-V20000*20000-V10000*10000-V5000*5000/2000<=2000){
            V2000=(vueltos-V100000*100000-V50000*50000-V20000*20000-V10000*10000-V5000*5000)/2000;
        }
        else{
            V2000=billetes2000;
        }
         if(vueltos-V100000*100000-V50000*50000-V20000*20000-V10000*10000-V5000*5000-V2000*2000/1000<=1000){
            V1000=(vueltos-V100000*100000-V50000*50000-V20000*20000-V10000*10000-V5000*5000-V2000*2000)/1000;
        }
        else{
            V1000=monedas1000;
        }
        if(vueltos-V100000*100000-V50000*50000-V20000*20000-V10000*10000-V5000*5000-V2000*2000-V1000*1000/500<=500){
            V1000=(vueltos-V100000*100000-V50000*50000-V20000*20000-V10000*10000-V5000*5000-V2000*2000-V1000*1000)/500;
        }
        else{
            V500=monedas500;
        }
        if(vueltos-V100000*100000-V50000*50000-V20000*20000-V10000*10000-V5000*5000-V2000*2000-V1000*1000-V500*500/200<=200){
            V200=(vueltos-V100000*100000-V50000*50000-V20000*20000-V10000*10000-V5000*5000-V2000*2000-V1000*1000-V500*500)/200;
        }
        else{
            V200=monedas200;
        }
        if(vueltos-V100000*100000-V50000*50000-V20000*20000-V10000*10000-V5000*5000-V2000*2000-V1000*1000-V500*500-V200*200/100<=100){
            V100=(vueltos-V100000*100000-V50000*50000-V20000*20000-V10000*10000-V5000*5000-V2000*2000-V1000*1000-V500*500-V200*200)/100;
        }
        else{
            V100=monedas100;
        }
        if(vueltos-V100000*100000-V50000*50000-V20000*20000-V10000*10000-V5000*5000-V2000*2000-V1000*1000-V500*500-V200*200-V100*100/50<=50){
            V50=(vueltos-V100000*100000-V50000*50000-V20000*20000-V10000*10000-V5000*5000-V2000*2000-V1000*1000-V500*500-V200*200-V100*100)/50;
        }
        else{
            V50=monedas50;
        }
        if (V100000*100000 + V50000*50000 +V20000*20000 +V10000*10000 +V5000*5000 +V2000*2000 +V1000*1000+V500*500 +V200*200+V100*100==vueltos){
            System.out.println("El vuelto es: ");
            System.out.println("Billetes de 100000: "+V100000);
            System.out.println("Billetes de 50000: "+V50000);
            System.out.println("Billetes de 20000: "+V20000);
            System.out.println("Billetes de 10000: "+V10000);
            System.out.println("Billetes de 5000: "+V5000);
            System.out.println("Billetes de 2000: "+V2000);
            System.out.println("Monedas de 1000: "+V1000);
            System.out.println("Monedas de 500: "+V500);
            System.out.println("Monedas de 200: "+V200);
            System.out.println("Monedas de 100: "+V100);
            System.out.println("Monedas de 50: "+V50);
            
        }
        else{
            System.out.println("No se puede dar el vuelto");
        }
    


       
        

    }
    
}
