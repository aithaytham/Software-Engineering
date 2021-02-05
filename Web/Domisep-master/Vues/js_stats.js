
function loadCharts() {
    Highcharts.chart('containerGraphTempHumi', {
        chart: {
            zoomType: 'x',
            backgroundColor:'rgba(255, 255, 255, 0.0)',
            type: 'line',
            style: {
                color: "#3498db"
            },
            resetZoomButton: {
              theme: {
                fill: '#e67e22',
                style:{
                  lineWidth: 0,
                  lineColor: '#2c3e50',
                  textTransform: 'uppercase',
                  fontWeight: 600,
                  color: '#2c3e50',
                }
              },
              hover: {
                       fill: '#3498db',
                       style: {
                           color: 'white'
                       }
              },
            }
        },
        title: {
            text: ' ',
            style: {
                color: "#bdc3c7"
            },
        },
        credits: {
          enabled: false
        },
        exporting:{
          enabled: false
        },
        subtitle: {
            text: document.ontouchstart === undefined ?
                    'Click and drag in the plot area to zoom in' : 'Pinch the chart to zoom in',
            style: {
                color: '#95a5a6'
            },

        },
        xAxis: {
            type: 'datetime',
            labels: {
              style: {
                color: '#bdc3c7',
              }

            },
        },
        yAxis: [{
            gridLineColor: '#2c3e50',
            title: {
                text: 't°',
                style:{
                  color: '#bdc3c7',
                }
            },
            labels: {
              style: {
                color: '#bdc3c7',
              },
            },
        },
        {
          opposite: true,
          title: {
              text: 'humidité°',
              style:{
                color: '#bdc3c7',
              }
          },
          gridLineWidth: 0,
          labels: {
            style: {
              color: '#bdc3c7',
            },
          },
        }],
        legend: {
            enabled: true,
            itemStyle: {
              color: '#bdc3c7',
              fontSize: '12px'
            } ,
        },
        plotOptions: {
            series: {
              animation: {
                  duration: 2500
              }
            },
        },

        series: [{
            type: 'spline',
            name: 'Température',
            yAxis: 0,
            lineColor: '#2980b9',
            marker: {
              enabled: false
            },
            shadow: {
              color: '#2980b9',
              width: 10
            },
            tooltip: {
            valueSuffix: ' °C'
        },

            data: [
                [Date.UTC(2017,5,2),17.4],
                [Date.UTC(2017,5,3),20.5],
                [Date.UTC(2017,5,4),25.6],
                [Date.UTC(2017,5,5),26.2],
                [Date.UTC(2017,5,6),24.9],
                [Date.UTC(2017,5,7),19.5],
                [Date.UTC(2017,5,9),25.6],
                [Date.UTC(2017,5,10),18.4],
                [Date.UTC(2017,5,11),16.2],
                [Date.UTC(2017,5,12),14.2],
                [Date.UTC(2017,5,13),13.6],
                [Date.UTC(2017,5,14),14.9],
                [Date.UTC(2017,5,16),13.8],
                [Date.UTC(2017,5,17),14.5],
                [Date.UTC(2017,5,18),16.1],
                [Date.UTC(2017,5,19),16.8]
              ]
        },
      {
            type: 'spline',
            name: 'Humidité',
            yAxis: 1,
            lineColor: '#16a085',
            marker: {
              enabled: false
            },
            shadow: {
              color: '#16a085',
              width: 10
            },
            tooltip: {
              valueSuffix: ' %'
        },

            data: [
                [Date.UTC(2017,5,2),5],
                [Date.UTC(2017,5,3),6],
                [Date.UTC(2017,5,4),4.2],
                [Date.UTC(2017,5,5),4.3],
                [Date.UTC(2017,5,6),6.8],
                [Date.UTC(2017,5,7),9.5],
                [Date.UTC(2017,5,9),4.5],
                [Date.UTC(2017,5,10),4.6],
                [Date.UTC(2017,5,11),4.7],
                [Date.UTC(2017,5,12),4.8],
                [Date.UTC(2017,5,13),5.6],
                [Date.UTC(2017,5,14),6.9],
                [Date.UTC(2017,5,16),6.8],
                [Date.UTC(2017,5,17),5.5],
                [Date.UTC(2017,5,18),4.1],
                [Date.UTC(2017,5,19),3.8]
              ]

      }]
    });

Highcharts.chart('containerConso', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie',
        backgroundColor:'rgba(255, 255, 255, 0.0)',
    },
    title: {
        text: '',
    },
    exporting: false,
    credits: false,
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            borderWidth: 0,
            size: '250vw',
            shadow: {
              offsetX: 0,
              offsetY: 0,
              color: '#2980b9',
              width: 10,
            },
            dataLabels: {
                enabled: false,
            }
        }
    },
    series: [{
        name: 'Consommation',
        colorByPoint: true,
        data: [{
            name: 'Chauffage',
            y: 35,
            sliced: true,
            color: '#16a085',
        }, {
            name: 'Lumière',
            y: 25,
            sliced: true,
            color: '#2980b9'
        }, {
            name: 'autres',
            y: 40,
            sliced: true,
            color: '#27ae60'
        }]
    }]
});

Highcharts.chart('containerluminosité', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        type: 'column',
        backgroundColor:'rgba(255, 255, 255, 0.0)',


    },
    title: {
        text: ''
    },
    exporting: false,
    credits: false,
    subtitle: {
        text: ''
    },
    legend: false,
    xAxis: {
        categories: [
            'Salon',
            'Cuisine',
            'Entrée',
            'Bureau',
            'Chambre 1',
            'Chambre 2',
            'WC',
            'Salle de bain',
        ],
        crosshair: true,
        labels:{
        style: {
          color: '#bdc3c7',
        },
      }
    },
    yAxis: {
        min: 0,
          gridLineColor: '#2c3e50',
        title: {
            text: 'Ensoleillement',
            style: {
              color: '#bdc3c7',
            },
        },
        labels:{
          style: {
            color: '#bdc3c7',
          },
        }
    },
    tooltip: {
    },
    plotOptions: {
        column: {
            pointPadding: 0.2,
            borderWidth: 0,
            color: '#3498db',
            shadow: {
              offsetX: 0,
              offsetY: 0,
              color: '#3498db',
              width: 8,

            }

        }
    },
    series: [{
        name: 'Luminosité',
        data: [75, 65, 70, 64, 35, 27, 15, 37]

    }],
});
}
