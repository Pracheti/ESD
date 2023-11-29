import axios from 'axios'
const OFFERS_URL_1 = "http://localhost:9191/offers/3.1/CSE/SDE"
const SAVE_URL_2 = "http://localhost:9191/placement_student/add"
class PlacementOfferServices{
    getOffers(){
        return axios.get(OFFERS_URL_1);
    }
    fillDetails(details){
        return axios.post(SAVE_URL_2, details);
    }
}
export default new PlacementOfferServices()
