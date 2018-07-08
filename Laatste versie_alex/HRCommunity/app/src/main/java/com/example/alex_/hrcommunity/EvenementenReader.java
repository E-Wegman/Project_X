package com.example.alex_.hrcommunity;

public class EvenementenReader {
        private String mtitelEvenement;
        private String mbeginTijdEvenement;
        private String meindTijdEvenement;
        private String mdatumEvenement;
        private int mIDEvenement;

        public EvenementenReader(String titelEvenement, String beginTijdEvenement, String eindTijdEvenement, String datumEvenement, int IDEvenement){
            mtitelEvenement = titelEvenement;
            mbeginTijdEvenement = beginTijdEvenement;
            meindTijdEvenement = eindTijdEvenement;
            mdatumEvenement = datumEvenement;
            mIDEvenement = IDEvenement;
        }

        public String gettitelEvenement(){
            return mtitelEvenement;
        }

        public String getbeginTijdEvenement(){
            return mbeginTijdEvenement;
        }

        public String geteindTijdEvenement(){
            return meindTijdEvenement;
        }

        public String getdatumEvenement(){
            return mdatumEvenement;
        }

        public int getIDEvenement(){
            return mIDEvenement;
        }

}
