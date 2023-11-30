import React, { Component } from 'react'
import PlacementOfferServices from '../services/PlacementOfferServices';
import ListOfferComponent from './ListOfferComponent';
import axios from 'axios';

class FillOfferDetails extends Component {
    constructor(props){
        super(props)
        this.state = {
            about: '',
            acceptance: 'ACCEPT',
            comments: '',
            date: this.getCurrentDate(),
            placement_id: 1,
            student_id: 1,
            file: null
        }
        this.changeAboutHandler = this.changeAboutHandler.bind(this);
        this.changeCommentsHandler = this.changeCommentsHandler.bind(this);
        this.changeDateHandler = this.changeDateHandler.bind(this);
        this.saveDetails = this.saveDetails.bind(this);
    }
    getCurrentDate() {
        const currentDate = new Date();
        const formattedDate = currentDate.toISOString().slice(0, 10);
        return formattedDate;
    }
    
    changeAboutHandler=(event)=>{
        this.setState({about: event.target.value});
    }
    changeCommentsHandler=(event)=>{
        this.setState({comments: event.target.value});
    }
    changeDateHandler=(event)=>{
        this.setState({date: event.target.value});
    }
    saveDetails=(e)=>{
        e.preventDefault();
        let details = {about: this.state.about, acceptance: this.state.acceptance, comments: this.state.comments, date: this.state.date, placement_id: this.state.placement_id, student_id: this.state.student_id};
        console.log('details => '+ JSON.stringify(details));
        PlacementOfferServices.fillDetails(details);

    }
    handleFile(e){
        let file = e.target.files[0]
        this.setState({file: e})
    }
    handleClick(e){
        let file=this.state.file
        let formdata = new formdata()
        formdata.append('file', file)
        formdata.append('name', "CV")
        axios({
            url:'',
            method: "post",
            data: formdata
        }).then((res)=>{

        })
    }
    render() {
    return (
        <div> 
            <div className='container'>
                <div className='row'>
                    <div className='card col-md-6 offset-md-3'>
                        <h3 className='text-center'> Fill Below details </h3>
                        <div className='card-body'>
                            <form>
                                <div className='form-group'>
                                    <label>About</label>
                                    <input placeholder='About' name='about' className='form-control' value={this.state.about} onChange={this.changeAboutHandler} />
                                </div>
                                <div className='form-group'>
                                    <label>Comments</label>
                                    <input placeholder='Comments' name='comments' className='form-control' value={this.state.comments} onChange={this.changeCommentsHandler} />
                                </div>
                                <div className='form-group'>
                                    <label>Date</label>
                                    <input placeholder='Date' name='date' className='form-control' value={this.state.date} onChange={this.changeDateHandler} readOnly/>
                                </div>
                                <div className='form-group'>
                                    <label>Upload CV</label>
                                    <input type='file' name='file' onChange={(e)=>this.handleFile(e)}/>
                                    <button type='button' onClick={(e)=>this.handleClick(e)}>Upload</button>
                                </div>
                                <button className='btn btn-success' onClick={this.saveDetails}>Save</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
  }
}

export default FillOfferDetails