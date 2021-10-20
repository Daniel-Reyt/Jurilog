import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { GetService } from '../service/get.service';
import { PostService } from '../service/post.service';

@Component({
  selector: 'app-balance',
  templateUrl: './balance.component.html',
  styleUrls: ['./balance.component.css']
})
export class BalanceComponent implements OnInit {
  id_client: any;
  balance:  any;

  constructor(private getService: GetService,
              private postSetvice: PostService) { }

  ngOnInit(): void {
    this.id_client = localStorage.getItem('id_client')
    this.getBalance();
  }

  isPositive(montant: number) {
    if (montant > 0) {
      return true
    } else {
      return false;
    }
  }
  
  getBalance() {
    this.getService.getBalanceByClient(this.id_client).toPromise().then((res: any) => {
      this.balance = res
    })
  }

  addMontant(oldMontant:number, montantToAdd: number) {
    console.log(oldMontant + montantToAdd);
    const new_montant = oldMontant + montantToAdd
    this.postSetvice.postNewBalance(this.id_client, this.balance.id, new_montant).toPromise().then((res: any) => {
      this.getBalance()
    })
  }
}
