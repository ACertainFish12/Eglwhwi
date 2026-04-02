package it.paranoidsquirrels.idleguildmaster.storage.data;

public class SnapshotData
{
    private byte[] data;
    private String description;
    
    public SnapshotData(final String description, final byte[] data) {
        this.description = description;
        this.data = data;
    }
    
    public byte[] getData() {
        return this.data;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setData(final byte[] data) {
        this.data = data;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
}
