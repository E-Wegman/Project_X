package com.example.alex_.hrcommunity;

public class EvenementenReader {
        private String mtitelEvenement;
        private String mbeginTijdEvenement;
        private String meindTijdEvenement;
        private String mdatumEvenement;
        private String mkleurEvenement;
        private int mIDEvenement;
        private int mPrioreitEvenement;

        public EvenementenReader(String titelEvenement, String beginTijdEvenement, String eindTijdEvenement, String datumEvenement, int IDEvenement, int PrioriteitEvenement, String KleurEvenement){
            mtitelEvenement = titelEvenement;
            mbeginTijdEvenement = beginTijdEvenement;
            meindTijdEvenement = eindTijdEvenement;
            mdatumEvenement = datumEvenement;
            mIDEvenement = IDEvenement;
            mPrioreitEvenement = PrioriteitEvenement;
            mkleurEvenement = KleurEvenement;
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

        public int getPrioreit() {
            return mPrioreitEvenement;
        }

        public String getkleurEvenement() {
            return mkleurEvenement;
        }
}
