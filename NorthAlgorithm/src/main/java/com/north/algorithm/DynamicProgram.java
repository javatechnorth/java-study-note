package com.north.algorithm;

public class DynamicProgram {


        public static void main(String[] args) {

            // 注意 hasNext 和 hasNextLine 的区别


            // while (in.hasNextInt()) { // 注意 while 处理多个 case
            //     int a = in.nextInt();
            //     int b = in.nextInt();
            //     System.out.println(a + b);
            // }
//            int M = in.nextInt();
//            int n = in.nextInt();
            int M = 1000;
            int n = 5;

            if(n<=0 || M <= 0) System.out.print(0);

            int[] vs = {800,400,300,400,500};
            int[] ps = {2,5,3,3,2};
            int[] qs = {0,1,1,0,0};

//            1000 5
//            800 2 0
//            400 5 1
//            300 5 1
//            400 3 0
//            500 2 0
            Good[] goods = new Good[n+1];
            for (int i = 1; i<=n ; i++){
                int v = vs[i-1];
                int p = ps[i-1];
                int q = qs[i-1];
                goods[i]= new Good(v,p,q);

                if(q > 0){
                    if(goods[i].a1 == 0){
                        goods[q].setA1(i);
                    }else{
                        goods[q].setA2(i);
                    }
                }

            }

            int[][] dp = new int[n+1][M+1];

            for (int i = 1; i<= n ; i++){
                int v=0,v1=0,v2=0 ,v3=0,tempdp=0,tempdp1=0,tempdp2=0,tempdp3=0;

                v = goods[i].v;

                tempdp = goods[i].p * v ;

                if(goods[i].a1 != 0){
                    v1 = goods[goods[i].a1].v +v;
                    tempdp1 = tempdp + goods[goods[i].a1].v * goods[goods[i].a1].p;
                }

                if(goods[i].a2 != 0 ){
                    v2 = goods[goods[i].a2].v + v;
                    tempdp2 = tempdp + goods[goods[i].a2].v * goods[goods[i].a2].p;
                }

                if(goods[i].a1 != 0 && goods[i].a2 !=0){
                    v3 = goods[goods[i].a1].v + goods[goods[i].a2].v + v;
                    tempdp3 = tempdp + goods[goods[i].a1].v * goods[goods[i].a1].p +goods[goods[i].a2].v * goods[goods[i].a2].p;
                }

                for (int j = 1; j<= M ; j++){
                    if(goods[i].q > 0){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i-1][j];
                        if(j >= v && v != 0) {
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j]) + tempdp;
                        }

                        if(j >= v1 && v1 != 0){
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v1]) +tempdp1;
                        }

                        if(j >= v2 && v2 != 0){
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v2] + tempdp2);
                        }

                        if(j >= v3 && v3 != 0){
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v3]) + tempdp3;
                        }
                    }
                }
            }

            System.out.print(dp[n-1][M]);

        }

        private static  class Good{
            public int v;
            public int p;
            public int q;

            public int a1 = 0;
            public int a2 = 0;

            public Good(){}
            public Good(int v, int p ,int q){
                this.v = v;
                this.p = p;
                this.q = q;
            }

            public void setA1(int a1){this.a1 = a1;}
            public void setA2(int a2){this.a2 = a2;}

        }

}
