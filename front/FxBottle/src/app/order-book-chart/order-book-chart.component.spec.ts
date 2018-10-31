import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderBookChartComponent } from './order-book-chart.component';

describe('OrderBookChartComponent', () => {
  let component: OrderBookChartComponent;
  let fixture: ComponentFixture<OrderBookChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderBookChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderBookChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
