package za.wethinkcode.avaj.simulate;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        setLongitude(longitude);
        setLatitude(latitude);
        setHeight(height);
    }

    public void setLongitude(int longitude) {
        if (longitude < 0) {
            longitude = 0;
        }
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        if (latitude < 0) {
            latitude = 0;
        }
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        if (height < 0) {
            height = 0;
        }
        if (height > 100) {
            height = 100;
        }
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}