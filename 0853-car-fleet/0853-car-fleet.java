class Solution {
    class car {
        int pos;
        double time;
        car(int pos,double time){
            this.pos=pos;
            this.time=time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        car[] cars = new car[position.length];
        
        for(int i=0;i<position.length;i++){
            double time = (target-position[i])/(speed[i]*1.0);
            cars[i]=new car(position[i],time);
        }
            Arrays.sort(cars,(a,b)->b.pos-a.pos);
        // for(car c:cars)
        // {
        //     System.out.println(c.pos+" "+c.time);
        // }
        int carFleet=1;
        double time = cars[0].time;
        for(int i=1;i<cars.length;i++){
            if(cars[i].time>time){
                carFleet++;
                time = cars[i].time;
            }
        }
        
            
        return carFleet;    
    }
}