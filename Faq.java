package it.paranoidsquirrels.idleguildmaster;

public enum Faq
{
    private static final Faq[] $VALUES;
    
    FAQ_1(2131887337, 2131887336), 
    FAQ_2(2131887331, 2131887330), 
    FAQ_3(2131887333, 2131887332), 
    FAQ_4(2131887804, 2131887338), 
    FAQ_5(2131887335, 2131887334);
    
    public int body;
    public int title;
    
    private Faq(final int title, final int body) {
        this.title = title;
        this.body = body;
    }
}
