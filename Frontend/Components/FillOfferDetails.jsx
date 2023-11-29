import React, { Component } from 'react'
import PlacementOfferServices from '../services/PlacementOfferServices';

class FillOfferDetails extends Component {
    constructor(props){
        super(props)
        this.state = {
            about: '',
            acceptance: 'ACCEPT',
            comments: '',
            date: ''
        }
        this.changeAboutHandler = this.changeAboutHandler.bind(this);
        this.changeCommentsHandler = this.changeCommentsHandler.bind(this);
        this.changeDateHandler = this.changeDateHandler.bind(this);
        this.saveDetails = this.saveDetails.bind(this);
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
        let details = {about: this.state.about, acceptance: this.state.acceptance, comments: this.state.comments, date: this.state.date};
        console.log('details => '+ JSON.stringify(details));
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
                                    <input placeholder='Date' name='date' className='form-control' value={this.state.date} onChange={this.changeDateHandler} />
                                </div>
                                <div className='form-group'>
                                    <label>Upload CV</label>
                                    <input placeholder='CV' name='cv' className='form-control' />
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