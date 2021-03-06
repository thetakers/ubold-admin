package com.ubold.admin.domain;

import com.ubold.admin.vo.*;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

/**
 * Created by lenovo on 2017/8/13.
 */
@Data
@Entity
@Table(name="TB_SM_DATAVIEW")
public class DataView extends Auditable{

    @Column(name = "dataviewcode")
    private String dataViewCode;

    @Column(name = "dataviewname")
    private String dataViewName;

    @Column(name = "sqlid")
    private String sqlId;
    private String remark;
    private String options;
    private String columns;

    @Column(name = "treeoptions")
    private String treeOptions;

    @Column(name = "datafilters")
    private String dataFilters;
    private String buttons;
}
