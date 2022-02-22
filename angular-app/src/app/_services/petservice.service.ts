import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { My_pets } from '../model/My_pets.model';

@Injectable({
  providedIn: 'root'
})
export class PetserviceService {

  private  baseUrl = "http://localhost:8081/petfinder/";  
  
  constructor(private http: HttpClient) { }  
  
  saveData(pet : My_pets) {  
      let url = this.baseUrl + "pet";  
      return this.http.post<My_pets>(url,pet);  
  }  
  
  uploadFile( file: File , id : number )  {  
    let url = this.baseUrl + "uploadImage/" + id ;  
    console.log('url ', url);
    const formdata: FormData = new FormData();  
    
    formdata.append('file', file);  
   
    return this.http.put(url , formdata);  
  }  

  getLostPets(){
    let url = this.baseUrl + "pet";  
    return this.http.get<My_pets[]>(url);  
  }
}  
