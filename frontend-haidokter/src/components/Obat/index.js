import React from "react";
import classes from "./styles.module.css";

const Obat = (props) => {
    const { nama, kuantitas } = props;
    return (
        <div className={classes.obat}>
            <p>{`Nama Obat ${nama}`}</p><p>{`(${kuantitas})`}</p>
        </div>
    );
};

export default Obat;