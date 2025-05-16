package com.xcelore.enums;

public enum Symptom {
    ARTHRITIS,
    BACK_PAIN,
    TISSUE_INJURIES,
    DYSMENORRHEA,
    SKIN_INFECTION,
    SKIN_BURN,
    EAR_PAIN;

    public Speciality getSpeciality() {
        return switch (this) {
            case ARTHRITIS, BACK_PAIN, TISSUE_INJURIES -> Speciality.ORTHOPAEDIC;
            case DYSMENORRHEA -> Speciality.GYNECOLOGY;
            case SKIN_INFECTION, SKIN_BURN -> Speciality.DERMATOLOGY;
            case EAR_PAIN -> Speciality.ENT;
        };
    }
}