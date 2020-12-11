import React from "react";
import classes from "./styles.module.css";
import Button from "../Button";
import Obat from "../Obat";

const Resep = (props) => {
    const { noResep, namaDokter, namaPasien, catatan, listObat, handleEdit, handleDelete } = props;
    return (
        <div className={classes.resep}>
            <h3>{`Resep Nomor ${noResep}`}</h3>
            <p>{`Nama Dokter: ${namaDokter}`}</p>
            <p>{`Nama Pasien: ${namaPasien}`}</p>
            <p>{`Nama Catatan: ${catatan}`}</p>
            <p>{listObat.map((obat) => (
                <Obat 
                    nama={obat.nama}
                    kuantitas={obat.kuantitas}
                />
            ))}</p>
            <Button onClick={handleEdit} variant="success">
                Edit
            </Button>
            <Button onClick={handleDelete} variant="danger">
                Delete
            </Button>
        </div>
    );
};

export default Resep;