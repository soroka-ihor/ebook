package com.elib.cover.model;

import com.elib.db.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "covers")
public class Cover extends BaseEntity {

    @Lob
    @Column (name = "image")
    private byte[] image;

}
