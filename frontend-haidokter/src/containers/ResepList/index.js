import React, { Component } from "react";
import Resep from "../../components/Resep";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/Button";
import Modal from "../../components/Modal";
//import ReactPaginate from "react-paginate"; //ini ide soal bonus latihan nomor 4 tapi belum jalan

const initState = {
    namaDokter: "",
    namaPasien: "",
    catatan: "",
}

class ResepList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            reseps: [],
            isLoading:false,
            isCreate: false,
            isEdit: false,
            search: null,
            //ini ide soal bonus latihan nomor 4 tapi belum jalan
            //offset: 0,
            //perPage: 5,
            //currentPage: 0,
            //pageCount: 0,
            namaDokter: "",
            namaPasien: "",
            catatan: "",
            listObat: [],
        };
        //this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleAddResep = this.handleAddResep.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitAddResep = this.handleSubmitAddResep.bind(this);
        this.handleEditResep = this.handleEditResep.bind(this);
        this.handleSubmitEditResep = this.handleSubmitEditResep.bind(this);
        this.handleDeleteResep = this.handleDeleteResep.bind(this);
        //ini ide soal bonus latihan nomor 4 tapi belum jalan
        //this.handlePagination = this.handlePagination.bind(this);
        //this.handlePageCount = this.handlePageCount.bind(this);
    }

    componentDidMount() {
        this.loadData();
    }

    async loadData() {
        try {
            const { data } = await APIConfig.get("/reseps");
            this.setState({ reseps: data });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async handleSubmitAddResep(event) {
        event.preventDefault();
        try {
            const data = {
            namaDokter: this.state.namaDokter,
            namaPasien: this.state.namaPasien,
            catatan: this.state.catatan,
            };
            await APIConfig.post("/resep", data);
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleSubmitEditResep(event) {
        event.preventDefault();
        try {
            const data = {
                namaDokter: this.state.namaDokter,
                namaPasien: this.state.namaPasien,
                catatan: this.state.catatan,
            };
            await APIConfig.put(`/resep/${this.state.noResep}`, data);
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleDeleteResep(noResep) {
        try {
            await APIConfig.delete(`/resep/${noResep}`);
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }        

    handleAddResep() {
        this.setState({ isCreate: true });
    }

    handleCancel(event) {
        event.preventDefault();
        this.setState({ isCreate: false, isEdit: false , ...initState });
    }

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }
    
    handleEditResep(resep) {
        this.setState({
            isEdit: true,
            noResep: resep.noResep,
            namaDokter: resep.namaDokter,
            namaPasien: resep.namaPasien,
            catatan: resep.catatan,
        });
    }

    searchBar = (event) => {
        let keyword = event.target.value;
        this.setState({ search:keyword });
    }

    
    //ini ide soal bonus latihan nomor 4 tapi belum jalan
    /* handlePagination = (event) => {
        const selectPage = event.selected;
        const offset = selectPage * this.state.perPage;
        this.setState({ currentPage: selectPage, offset: offset}, () => {this.loadData()});
    } */
    //ini ide soal bonus latihan nomor 4 tapi belum jalan
    /* handlePageCount() {
        const dataResep = this.state.reseps;
        this.setState({ pageCount: Math.ceil(dataResep.length / this.state.perPage) });
    } */
        


    // shouldComponentUpdate(nextProps, nextState) {
    //     console.log("shouldComponentUpdate()");
    //     return true;
    // }

    // handleClickLoading() {
    //     const currentLoading = this.state.isLoading;
    //     this.setState({ isLoading: !currentLoading });
    //     console.log(this.state.isLoading);
    // }

    render() {
        //console.log("render()");
        const resepItem = this.state.reseps.filter((resep) => {
            if(this.state.search == null){
                return resep;
            }
            else if(resep.namaDokter.toLowerCase().includes(this.state.search.toLowerCase())){
                return resep;
            }
        }).map((resep) => {
            return (
                <Resep
                    key={resep.noResep}
                    noResep={resep.noResep}
                    namaDokter={resep.namaDokter}
                    namaPasien={resep.namaPasien}
                    catatan={resep.catatan}
                    listObat={resep.listObat}
                    handleEdit={() => this.handleEditResep(resep)}
                    handleDelete={() => this.handleDeleteResep(resep.noResep)}
                />
            );
        });

        return (
            <div className={classes.resepList}>
                <h1 className={classes.title}>All Reseps</h1>
                <Button onClick={this.handleAddResep} variant="primary">
                    Add Resep
                </Button>
                <div>
                    <input
                        className={classes.textField}
                        type="text"
                        placeholder="Masukkan nama dokter"
                        onChange={(e) => this.searchBar(e)}
                    />
                    {resepItem}
                </div>
                {/* <div>
                    {this.state.reseps.map((resep) => (
                    <Resep
                        key={resep.noResep}
                        noResep={resep.noResep}
                        namaDokter={resep.namaDokter}
                        namaPasien={resep.namaPasien}
                        catatan={resep.catatan}
                        handleEdit={() => this.handleEditResep(resep)}
                        handleDelete={() => this.handleDeleteResep(resep.noResep)}
                    />
                    ))}
                </div> */}
                <Modal 
                    show={this.state.isCreate || this.state.isEdit}
                    handleCloseModal={this.handleCancel}
                    >
                    <form>
                        <h3 className={classes.modalTitle}>
                            {this.state.isCreate
                            ? "Add Resep"
                            : `Edit Resep Nomor ${this.state.noResep}`}
                        </h3>
                        <input
                            className={classes.textField}
                            type="text"
                            placeholder="Nama Dokter"
                            name="namaDokter"
                            value={this.state.namaDokter}
                            onChange={this.handleChangeField}
                        />
                        <input
                            className={classes.textField}
                            type="text"
                            placeholder="Nama Pasien"
                            name="namaPasien"
                            value={this.state.namaPasien}
                            onChange={this.handleChangeField}
                        />
                        <textarea
                            className={classes.textField}
                            placeholder="Catatan"
                            name="catatan"
                            rows="4"
                            value={this.state.catatan}
                            onChange={this.handleChangeField}
                        />
                        <Button
                            onClick={
                                this.state.isCreate
                                ? this.handleSubmitAddResep
                                : this.handleSubmitEditResep
                            }
                            variant="primary"
                        >
                            {this.state.isCreate ? "Create" : "Edit"}
                        </Button>
                        <Button onClick={this.handleCancel} variant="danger">
                            Cancel
                        </Button>
                    </form>
                </Modal>
            </div>
        );

        //ini ide untuk soal bonus latihan nomor 4 tapi belum jalan
        /* return(
            <div>
                <ReactPaginate 
                    previousLabel={"prev"}
                    nextLabel={"next"}
                    pageCount={this.handlePageCount}
                    onPageChange={this.handlePagination}
                    marginPagesDisplayed={2}
                    pageRangeDisplayed={5}
                />
            </div>
        ); */
    }
}

export default ResepList;