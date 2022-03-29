package com.company;

class Data {
    private int gg;
    private int aa;
    private int mm;
    private int ggAgg;
    private int mmAgg;
    private int aaAgg;
    private String ggStr;
    private String mmStr;
    private int aggiungiGiorni;
    private int i;
    private int somma;

    //Costruttore

    public Data(int gg, int mm, int aa) {
        this.gg = gg;
        this.mm = mm;
        this.aa = aa;
    }

    int giorniMese(int mm, int aa) {
        int giorni;
        switch (mm) {
            case 11:
            case 4:
            case 6:
            case 9: {
                giorni = 30;
                break;
            }

            case 2: {
                giorni = bisestile(aa);
                break;
            }

            default: {
                giorni = 31;
                break;
            }
        }
        return giorni;
    }


    int bisestile(int aa) {
        int giorni;
        if (aa % 4 == 0) {
            if (aa % 100 == 0) {
                if (aa % 400 == 0) {
                    giorni = 29;
                } else {
                    giorni = 28;
                }
            } else {
                giorni = 29;
            }
        } else {
            giorni = 28;
        }
        return giorni;
    }

    void aggiungiG(int aggiungiGiorni) {
        this.aggiungiGiorni = aggiungiGiorni;

        int temp;
        temp = gg + aggiungiGiorni;
        mmAgg = mm;
        aaAgg = aa;

        while (temp > (giorniMese(mmAgg, aaAgg))) {
            temp = temp - (giorniMese(mmAgg, aaAgg));
            mmAgg = mmAgg + 1;
            if (mmAgg > 12) {
                aaAgg = aaAgg + 1;
            }
        }
        ggAgg = temp;

        formattaVatiabili(ggAgg, mmAgg);
    }

    private void formattaVatiabili(int g, int m) {
        if (g < 10) {
            ggStr = "0" + g;
        } else {
            ggStr = "" + g;
        }

        if (m < 10) {
            mmStr = "0" + m;
        } else {
            mmStr = "" + m;
        }
    }

    int fineAnno (){
        int i;
        somma = giorniMese(mm, aa)-gg;
        i = mm + 1;

        while (i <= 12){
            somma = somma + giorniMese(i, aa);
            i = i + 1;
        }
        return somma;
    }

    //getter
    public String getGGStr() {
        return ggStr;
    }

    public String getMMStr() {
        return mmStr;
    }

    public int getAAAgg() {
        return aaAgg;
    }

   public int getSomma() {
        return somma;
   }

}
