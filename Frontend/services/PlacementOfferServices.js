import axios from 'axios'
//import Login from '../Components/Login'

const OFFERS_URL_1 = "http://localhost:9191/offers/3.1/CSE/ML"
const SAVE_URL_2 = "http://localhost:9191/placement_student/add"
class PlacementOfferServices{
    getOffers(){
        return axios.get(OFFERS_URL_1);
    }
    fillDetails(formdata){
        return axios.post(SAVE_URL_2, formdata, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
            
    });
    }
}
export default new PlacementOfferServices()
