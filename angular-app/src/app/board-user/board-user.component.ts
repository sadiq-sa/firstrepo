import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DataConstants } from '../model/Data-constants.model';
import { My_pets } from '../model/My_pets.model';
import { PetserviceService } from '../_services/petservice.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {
  content = '';
  registerForm: FormGroup;
  submitted = false;
  // petTypes= [];
  selectedFiles: FileList;
  currentFileUpload: File;
  // petTypeval : any;
  pet: My_pets = new My_pets();
  // DataConstants.petTypes
  petTypes: string[] = [
    'Cat',
    'Dog',
    'Hamster',
    'Bird',
    'Rabbit',
    'Fish',
    'Lizard',
    'Horse',
    'Gerbil',
    'Tortoise'];
  City: any = ['Florida', 'South Dakota', 'Tennessee', 'Michigan']

  constructor(private userService: UserService, private formBuilder: FormBuilder,
    private petserviceService: PetserviceService) { }

  ngOnInit() {

    //  console.log(petTypes.filter(elt => elt.));  
    this.userService.getUserBoard().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );


    this.registerForm = this.formBuilder.group({
      name: ['', Validators.required],
      missingSince: ['', Validators.required],
      petType: ['', [Validators.required]],
      petImg: [null]
    });
  }


  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onChange(event) {
    const file = event.target.files;
    this.selectedFiles = event.target.files;
    this.currentFileUpload = this.selectedFiles[0];
    }

  onSubmit() {
    console.log('submit');
    this.submitted = true;
    if (this.registerForm.invalid) {
      console.log('invalid');
      return;
    }
    this.pet.name = this.registerForm.controls.name.value;
    this.pet.missingSince = this.registerForm.controls.missingSince.value + ' 00:00:00.000';
    this.pet.petType = this.registerForm.controls.petType.value;
    console.log(this.pet.missingSince);
    this.petserviceService.saveData(this.pet).subscribe(data => {
      data;
      console.log('----', data.petId);
      if (data) {
        if (this.selectedFiles != null) {
          this.currentFileUpload = this.selectedFiles.item(0);
          console.log(this.currentFileUpload);
        }
        this.petserviceService.uploadFile(this.currentFileUpload, data.petId).subscribe(
          res => {
            console.log('res ', res);
            if (res) {
              console.log('file upload sucess');
              this.registerForm.reset();
            }
            else {
              alert('error while uploading fie details');
            }
          },
          err => {
            alert('error while uploading fie details');
          }
        );
      }
    },
      error => {
        console.log('error while saving data in the DB');
      });
  }

}