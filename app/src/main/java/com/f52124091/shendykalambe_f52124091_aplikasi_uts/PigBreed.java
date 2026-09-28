package com.f52124091.shendykalambe_f52124091_aplikasi_uts;

public class PigBreed {
    private String name;
    private String origin;
    private String characteristics;
    private String type;
    private int imageResId;

    public PigBreed(String name, String origin, String characteristics, String type, int imageResId) {
        this.name = name;
        this.origin = origin;
        this.characteristics = characteristics;
        this.type = type;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public String getType() {
        return type;
    }

    public int getImageResId() {
        return imageResId;
    }
}
