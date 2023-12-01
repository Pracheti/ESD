import React, { Component } from 'react'
//import { useState } from 'react';
import PlacementOfferServices from '../services/PlacementOfferServices';
import ListOfferComponent from './ListOfferComponent';

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

        const formData = new FormData();
    formData.append('file', this.state.file);
    //formData.append('name', 'CV');
    formData.append('about', this.state.about);
    formData.append('acceptance', this.state.acceptance);
    formData.append('comments', this.state.comments);
    formData.append('date', this.state.date);
    formData.append('placement_id', this.state.placement_id);
    formData.append('student_id', this.state.student_id);


        /*let formdata = new FormData();
        formdata.append('file', this.state.file);
        formdata.append('name', "CV");
        let details = {about: this.state.about, acceptance: this.state.acceptance, comments: this.state.comments, date: this.state.date, placement_id: this.state.placement_id, student_id: this.state.student_id};
        console.log('details => '+ JSON.stringify(details));*/
        PlacementOfferServices.fillDetails(formData)
        .then(response => {
            console.log('File uploaded successfully!!!', response);
        })
        .catch(error => {
            console.error('Error uploading file', error);
        });
    }
    handleFile(e){
        let file = e.target.files[0]
        this.setState({file: file})
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