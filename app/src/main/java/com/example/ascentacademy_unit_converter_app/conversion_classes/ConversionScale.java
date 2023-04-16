package com.example.ascentacademy_unit_converter_app.conversion_classes;

public class ConversionScale {

    public enum MassScale{
//        Metric Unit
        TON(1000000.0),
        KG(1000.0),
        HG(100.0),
        DAG(10.0),
        G(1.0),
        DG(0.1),
        CG(0.01),
        MG(0.001),
        UG(0.000001),
//        Imperial Unit
        LBS(453.59237),
        OZ(28.3495231);

        public final double scaleValue;
        MassScale(double scaleValue){
            this.scaleValue=scaleValue;
        }
    }

    public enum LengthScale{
//        Metric Unit
        KM(1000.0),
        HM(100.0),
        DAM(10.0),
        M(1.0),
        DM(0.1),
        CM(0.01),
        MM(0.001),
        UM(0.000001),
//       Imperial Unit
        MI(1609.344),
        FT(0.3048),
        YD(0.9144),
        IN(0.0254);
        public final double scaleValue;
        LengthScale(double scaleValue){
            this.scaleValue=scaleValue;
        }
    }

    public static class TemperatureScale{
//        For celsius input
        public static double cToF(double c){
            return c*(9.0/5.0)+32.0;
        }
        public static double cToK(double c){
            return c+273.15;
        }
//         For fahrenheit input
        public static double fToC(double f){
            return (f-32.0)*(5.0/9.0);
        }
        public static double fToK(double f){
            return (f-32.0)/1.8 + 273.15;
        }
//          For Kelvin input
        public static double kToC(double k){
            return k-273.15;
        }
        public static double kToF(double k){
            return 1.8*(k-273.15)+32.0;
        }
    }

    public enum TimeScale{
        YR(365.25),
        MTH(30.4166667),
        WK(7.0),
        DAY(1.0),
        HR(0.04166667),
        MIN(0.0006944444),
        S(0.00001157),
        MS(0.000000011574);

        public final double scaleValue;
        TimeScale(double scaleValue){
            this.scaleValue=scaleValue;
        }
    }

    public enum DataScale{
        TB(1048576.0),
        GB(1024.0),
        MB(1.0),
        KB(0.0009765625),
        B(0.000000953674316);

        public final double scaleValue;
        DataScale(double scaleValue){
            this.scaleValue=scaleValue;
        }
    }
}
