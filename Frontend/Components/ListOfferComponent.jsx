import React, { Component } from 'react'
import PlacementOfferServices from '../services/PlacementOfferServices'

class ListOfferComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
            offers:[]
        }
    }
    componentDidMount(){
        PlacementOfferServices.getOffers().then((res) => {
            this.setState({offers: res.data});
        });
    }
    render() {
    return (
        <div>
        <h2 className="text-center">List of Offers</h2>
        <div className="row">
            <table className="table table-striped table bordered">
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Intake</th>
                        <th>Organization</th>
                        <th>Profile</th>
                        <th>Domain</th>
                        <th>Specialization</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.offers.map(
                            offers => 
                            <tr key = {offers.id}>
                                <td> {offers.Description} </td>
                                <td> {offers.Intake} </td>
                                <td> {offers.Organization} </td>
                                <td> {offers.Profile} </td>
                                <td> {offers.Domain} </td>
                                <td> {offers.Specialization} </td>
                            </tr>
                        )
                    }
                </tbody>
            </table> 
        </div>
        </div>
    )
  }
}
export default ListOfferComponent