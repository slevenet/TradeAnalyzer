import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderBookDetailComponent } from './order-book-detail.component';

describe('OrderBookDetailComponent', () => {
  let component: OrderBookDetailComponent;
  let fixture: ComponentFixture<OrderBookDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderBookDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderBookDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
