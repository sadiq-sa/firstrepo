import { Component, OnInit } from '@angular/core';
import { My_pets } from '../model/My_pets.model';
import { PetserviceService } from '../_services/petservice.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  content: string;
  image: any;
  imageSrc: string;
  petsData: My_pets[];
  constructor(private userService: UserService,
    private petservice: PetserviceService) { }

  ngOnInit() {
    this.petsData = [];
    this.userService.getPublicContent().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  
    this.petservice.getLostPets().subscribe(
      data => {       
        this.petsData = data;
        console.log(this.petsData);
        this.petsData.forEach(elt => elt.petImg = 'data:image/jpeg;base64,' +elt.petImg);
      }
    );  
  }
}
